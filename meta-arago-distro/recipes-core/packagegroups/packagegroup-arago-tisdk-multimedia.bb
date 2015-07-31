DESCRIPTION = "Task to add multimedia related packages"
LICENSE = "MIT"
PR = "r13"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MULTIMEDIA = ""

MULTIMEDIA_append_omap3 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_ti33x = " \
    amsdk-av-files \
"

MULTIMEDIA_append_ti43x = " \
    dual-camera-demo \
    image-gallery \
    amsdk-av-files \
"

MULTIMEDIA_append_omap-a15 = " \
    amsdk-av-files \
"

MULTIMEDIA_append_am37x-evm = " \
    av-examples \
"

MULTIMEDIA_append_omap5-evm = " \
    abefw \
    "

MULTIMEDIA_append_am3517-evm = " \
    av-examples \
"

ACCEL_FW = ""
ACCEL_FW_append_am57xx-evm = " \
    ${@base_contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
    "

ACCEL_FW_append_omap5-evm = " \
    ${@base_contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
    "

ACCEL_FW_append_dra7xx-evm = " \
    ${@base_contains('MACHINE_FEATURES', 'mmip', 'ipumm-fw', '', d)} \
    vis \
    "


# Disable for now, until IPC gets merged to 4.1 kernel
#    packagegroup-arago-gst
#    ${ACCEL_FW}

RDEPENDS_${PN} = "\
    ${MULTIMEDIA} \
"
