FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_GL = "gles2 icu linuxfb"

SRC_URI += " \
	file://0001-qeglfswindow.cpp.patch \
	file://0002-qeglfswindow.cpp.patch \
"

PR_append = "-arago0"
