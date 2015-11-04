DESCRIPTION = "Task to install sources for additional utilities/demos for SDKs"
LICENSE = "MIT"
PR = "r15"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

UTILS = " \
    am-sysinfo-src \
    arm-benchmarks-src \
    oprofile-example-src \
"

# Add pru and profibus sources for omapl138 devices
UTILS_append_am180x-evm = " \
    ti-pru-sw-examples-src \
"

UTILS_append_omap-a15 = " \
    omapconf-src \
"

UTILS_append_ti33x = " \
    omapconf-src \
"

UTILS_append_dra7xx = " \
    opencl-examples-src \
"

EXTRA_LIBS = ""

EXTRA_LIBS_append_omap-a15 = " \
    cmem-mod-src \
"

EXTRA_LIBS_append_dra7xx = " \
    debugss-module-drv-src \
    gdbserverproxy-module-drv-src \
"

EXTRA_LIBS_append_keystone = " \
    cmem-mod-src \
    uio-module-drv-src \
    hplib-mod-src \
"

RDEPENDS_${PN} = "\
    ${UTILS} \
    ${EXTRA_LIBS} \
"
