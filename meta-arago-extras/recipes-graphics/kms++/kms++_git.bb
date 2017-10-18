SUMMARY = "C++ library for kernel mode setting"
HOMEPAGE = "https://github.com/tomba/kmsxx"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c670e18272184fc0e86e1648678b4f2a"

PV = "1.0"
PR = "r3"

BRANCH = "master"
SRC_URI = "git://github.com/tomba/kmsxx.git;protocol=git;branch=${BRANCH}"
SRCREV = "cb0786049f960f2bd383617151b01318e02e9ff9"

DEPENDS = "drm python3-pybind11"

PACKAGES =+ "${PN}-python"

RDEPENDS_${PN}-python += "python3-core"

FILES_${PN}-python += "${libdir}/python*/site-packages"

S = "${WORKDIR}/git"

inherit python3native cmake update-alternatives

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE_${PN} = "kmstest"
ALTERNATIVE_LINK_NAME[kmstest] = "${bindir}/kmstest"
