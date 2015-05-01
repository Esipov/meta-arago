FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "faad ${@base_contains('DISTRO_FEATURES','wayland','wayland','',d)}"

DEPENDS_append_dra7xx = " \
    libdce \
    libdrm \
"

SRC_URI_append = " \
        file://0001-Added-GstDRMBufferPool-support.patch \
        file://0002-Modified-waylandsink-to-accept-NV12-format.patch \
        file://0003-Added-KMSsink-support.patch \
        file://0004-waylandsink-Removed-dependency-on-dri2.patch \
        file://0005-vc1parse-and-jpegparse-Fixes-plugin-ranks.patch \
        file://0006-GstDRMBufferPool-support-fix.patch \
"

PR_append = "-arago1"
