FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "-arago0"

SRC_URI += "file://remove-gets.patch"
