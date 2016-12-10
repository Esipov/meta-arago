FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = ".arago6"

is_armv7 = "1"

SRC_URI = "git://git.ti.com/optee/ti-optee-os.git;branch=${BRANCH} \
           file://0001-allow-setting-sysroot-for-libgcc-lookup.patch \
"
BRANCH = "ti_optee_os-next"
SRCREV = "8573c0500487bd341aa5b37870ac92fc54292914"

EXTRA_OEMAKE = "CROSS_COMPILE_core=${HOST_PREFIX}  \
                CROSS_COMPILE_ta_arm32=${HOST_PREFIX}  \
                ta-targets=ta_arm32 \
                LIBGCC_LOCATE_CFLAGS=--sysroot=${STAGING_DIR_HOST} \
                CFG_TEE_TA_LOG_LEVEL=0 \
"

do_compile() {
    unset LDFLAGS
    export TI_SECURE_DEV_PKG=${TI_SECURE_DEV_PKG}
    oe_runmake all PLATFORM=${OPTEEMACHINE} PLATFORM_FLAVOR=${OPTEEFLAVOR}
    ( cd out/arm-plat-${OPTEEOUTPUTMACHINE}/core/; \
        ${TI_SECURE_DEV_PKG}/scripts/secure-binary-image.sh tee.bin tee.bin.signed; \
        normfl=`echo ${OPTEEFLAVOR} | tr "_" "-"`
        mv tee.bin.signed $normfl.optee; \
    )
}

do_install() {
    #install core on boot directory
    install -d ${D}/boot
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${D}/boot

    #install TA devkit
    install -d ${D}/usr/include/optee/export-user_ta/
    for f in  ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/export-ta_${OPTEE_ARCH}/* ; do
        cp -aR $f ${D}/usr/include/optee/export-user_ta/
    done
}

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 644 ${B}/out/arm-plat-${OPTEEOUTPUTMACHINE}/core/*.optee ${DEPLOYDIR}
}

FILES_${PN} = "/boot"
