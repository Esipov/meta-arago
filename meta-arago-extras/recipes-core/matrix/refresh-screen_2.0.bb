DESCRIPTION = "Simple Application to force a screen refresh"
HOMEPAGE = "https://gitorious.org/matrix-gui-v2/refresh-screen"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=9;endline=37;md5=884b90f5bf0d711fe32c4f04b5276496"
SECTION = "multimedia"

# Make sure that QT font libraries have been installed
RDEPENDS += "qt4-embedded-fonts"

PR = "r0"

SRCREV = "ba27273f0d61dd71589db380f785f091b7ad3efe"
BRANCH ?= "master"

SRC_URI = "git://gitorious.org/matrix-gui-v2/refresh-screen.git;protocol=git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit qt4e

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/refresh_screen ${D}/${bindir}
}
