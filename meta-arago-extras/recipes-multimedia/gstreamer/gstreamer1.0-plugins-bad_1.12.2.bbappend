FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "faad"
PACKAGECONFIG += "kms"

# gstreamer is now also included on Keystone, be mindful of any Graphics dependencies
PACKAGECONFIG_append_omap-a15 = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti43x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"
PACKAGECONFIG_append_ti33x = " ${@bb.utils.contains('DISTRO_FEATURES','wayland','wayland','',d)}"

DEPENDS_append_omap-a15 = " \
    libdrm \
"

DEPENDS_append_ti43x = " \
    libdrm \
"

DEPENDS_append_ti33x = " \
    libdrm \
"

SRC_URI_append_ti43x = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-bug-fixes-on-parsers.patch \
    file://0003-kmssink-Add-omapdrm-in-the-list-of-driver-modules.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
"

SRC_URI_append_ti33x = " \
"

SRC_URI_append_omap-a15 = " \
    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
    file://0002-parsers-bug-fixes-on-parsers.patch \
    file://0003-kmssink-Add-omapdrm-in-the-list-of-driver-modules.patch \
    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PR = "r4"
