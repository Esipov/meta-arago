DESCRIPTION = "Imagination PowerVR SDK binaries for Jacinto6 SoC"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://Jacinto6-IMG-PowerVR-SDK-Manifest.pdf;md5=46bcbfc69f8837c339e15fd4a5044a8c"

BRANCH_omap-a15 = "master"
BRANCH_ti33x = "am4/k4.1"
BRANCH_ti43x = "am4/k4.1"

SRC_URI = "git://git.ti.com/graphics/img-pvr-sdk.git;protocol=git;branch=${BRANCH}"
SRCREV_omap-a15 = "c2456ec3f03da022fb7489d6b381a4ac26a68203"
SRCREV_ti33x = "f753b6c00168f9dd534c2b34206845d3cdddabe6"
SRCREV_ti43x = "f753b6c00168f9dd534c2b34206845d3cdddabe6"

PR = "r1"

COMPATIBLE_MACHINE = "dra7xx|ti43x|ti33x"

S = "${WORKDIR}/git"

do_install () {
    install -d ${D}/opt/img-powervr-sdk
    cp -ar ${S}/targetfs/PVRHub ${D}/opt/img-powervr-sdk
    cp -ar ${S}/targetfs/PVRScopeDeveloper ${D}/opt/img-powervr-sdk

    install -d ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2ChameleonMan ${D}${bindir}/SGX/demos/Raw/
}

do_install_append_omap-a15 () {
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2Coverflow ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2ExampleUI ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2Navigation ${D}${bindir}/SGX/demos/Raw/
}

do_install_append_ti33x () {
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLESEvilSkull ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLESFilmTV ${D}${bindir}/SGX/demos/Raw/
}

do_install_append_ti43x () {
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLES2MagicLantern ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLESEvilSkull ${D}${bindir}/SGX/demos/Raw/
    install -m 755 ${S}/targetfs/Examples/Advanced/OGLESFilmTV ${D}${bindir}/SGX/demos/Raw/
}

INHIBIT_PACKAGE_STRIP = "1"

INSANE_SKIP_${PN} += "dev-so staticdev"

FILES_${PN} += " \
    /opt/img-powervr-sdk/PVRHub/* \
    /opt/img-powervr-sdk/PVRScopeDeveloper/* \
"
