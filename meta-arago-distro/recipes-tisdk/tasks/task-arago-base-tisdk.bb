DESCRIPTION = "Additional packages beyond console packages shared by TI SDKs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

SECONDARY_BOOTLOADER = ""
SECONDARY_BOOTLOADER_omap3 = "u-boot-spl"

RDEPENDS_${PN} = "\
    dbus \
    dbus-x11 \
    expat \
    glib-2.0 \
    libxml2 \
    libpcre \
    iptables \
    iperf \
    psplash-ti \
    u-boot \
    arago-gpl-notice \
    nfs-utils-client \
    ${SECONDARY_BOOTLOADER} \
    "
