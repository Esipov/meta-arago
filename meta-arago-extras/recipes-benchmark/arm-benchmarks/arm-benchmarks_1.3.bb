DESCRIPTION = "ARM Benchmarks"
HOMEPAGE = "https://gforge.ti.com/gf/project/am_benchmarks/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=7aefb5e1cffc7b6a3ef18b803f957922"
SECTION = "system"

SRCREV = "76"
PR = "r1+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/am_benchmarks/;module=trunk;protocol=https;user=anonymous;pswd=''"

S = "${WORKDIR}/trunk"

do_compile() {
	export CROSS_COMPILE=${TARGET_PREFIX}
	export ARCH=${ARMPKGARCH}
	# build the release version
	make release
}

do_install() {
	export ARCH=${ARMPKGARCH}
	make DESTDIR=${D} install
}
