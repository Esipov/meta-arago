DESCRIPTION = "Task to build and install Qt embedded headers and libs into the sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PR = "r0"

inherit task

RDEPENDS_${PN} = "\
    qt4-embedded-dev \
    qt4-embedded-mkspecs \
    libqt-embeddedphonon4-dev \
    libqt-embedded3support4-dev \
    libqt-embeddedclucene4-dev \
    libqt-embeddedcore4-dev \
    libqt-embeddeddbus4-dev \
    libqt-embeddeddesignercomponents4-dev \
    libqt-embeddeddesigner4-dev \
    libqt-embeddeduitools4-dev \
    libqt-embeddedgui4-dev \
    libqt-embeddedhelp4-dev \
    libqt-embeddednetwork4-dev \
    libqt-embeddedscript4-dev \
    libqt-embeddedscripttools4-dev \
    libqt-embeddedsvg4-dev \
    libqt-embeddedtest4-dev \
    libqt-embeddedwebkit4-dev \
    libqt-embeddedxml4-dev \
"
