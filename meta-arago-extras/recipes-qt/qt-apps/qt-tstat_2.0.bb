DESCRIPTION = "Qt Thermostat Demo"
HOMEPAGE = "https://gitorious.org/thermostat-demo"

LICENSE = "BSD & CC-BY-SA-2.0 & CC-BY-SA-3.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93a105adb99011afa5baee932b560714 \
                    file://IMAGE-LICENSE;md5=fce98146123de13a189c234a5e4cfa0d \
                    file://API-LICENSE;md5=5e32280d79a1eab76729c50d79ecfe72 \
                    file://remote/MIT-LICENSE.txt;md5=6a24093faaae5d5c198578c88e220071 \
"

require recipes-core/matrix/matrix-gui-paths.inc

inherit qt-provider

PR = "r6"

DEPENDS += "${QT_DEPENDS_SVG} ${QT_DEPENDS_SCRIPT}"

BRANCH ?= "master"
SRCREV = "e6225f9e485675e4390dcc7575810e9f63501692"

SRC_URI = " \
	git://gitorious.org/thermostat-demo/thermostat-demo.git;protocol=git \
"

SRC_URI += "${@base_conditional('QT_PROVIDER', 'qt5', 'file://0002-Replace-QtGui-with-QtWidgets-per-Qt5-migration-guide.patch \
	file://0003-Replace-fromAscii-toAscii-with-fromLatin1-toLatin1-p.patch', '', d)}"

S = "${WORKDIR}/git/"

BUILDDIR ?= "."

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${BUILDDIR}/ThermostatDemo ${D}/usr/bin/ThermostatDemo
	install -d ${D}${MATRIX_APP_DIR}/qt_tstat
	cp -rf matrix-files/*  ${D}${MATRIX_APP_DIR}/qt_tstat
}

PACKAGES += "matrix-gui-thermostat-demo"

RDEPENDS_matrix-gui-thermostat-demo += "matrix-gui-apps-images matrix-gui-submenus-qt4"

FILES_matrix-gui-thermostat-demo += "${MATRIX_APP_DIR}/*"
