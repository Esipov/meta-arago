DESCRIPTION = "Task to install graphics binaries"
LICENSE = "MIT"
PR = "r12"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_WESTON = "\
    weston \
    weston-init \
    weston-examples \
"

# Until SGX is fixed with 4.1 - omap3-sgx-modules
GRAPHICS_SDK = "\
    libgles-omap3 \
    libgles-omap3-blitwsegl \
    libgles-omap3-flipwsegl \
    libgles-omap3-frontwsegl \
    libgles-omap3-linuxfbwsegl \
    libgles-omap3-rawdemos \
"

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    libgbm \
    omap5-sgx-ddk-um-linux \
    omapdrm-pvr \
"

GRAPHICS_RDEPENDS_ti43x = "\
    libgbm \
    omap5-sgx-ddk-um-linux \
    omapdrm-pvr \
"

GRAPHICS_RDEPENDS_omap3 = "\
    ${GRAPHICS_SDK} \
"

GRAPHICS_RDEPENDS_omap-a15 = "\
    libgbm \
    omap5-sgx-ddk-um-linux \
    omapdrm-pvr \
    "

RDEPENDS_${PN} = "\
    ${@base_contains('DISTRO_FEATURES', 'wayland', "${GRAPHICS_WESTON}", '', d)} \
    ${GRAPHICS_RDEPENDS} \
"
