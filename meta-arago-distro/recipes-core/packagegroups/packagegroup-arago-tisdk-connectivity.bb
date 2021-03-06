DESCRIPTION = "Task to install wireless packages into the target FS"
LICENSE = "MIT"
PR = "r39"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Disabled in master:
#    crda
# WLAN support packages.
# These are the packages that all platforms use for WLAN support
WLAN_COMMON = "\
    wireless-tools \
    iw \
    softap-udhcpd-config \
    eventdump \
    wlconf \
    wpa-supplicant-wl18xx \
    hostap-daemon-wl18xx \
    wl18xx-calibrator \
    wl18xx-target-scripts \
"

# netperf has non-standard license, needs verifying
#    netperf

FIRMWARE_AND_DRIVERS = "\
    wl18xx-fw \
    bt-fw \
    linux-firmware-iwlwifi-8000c \
    linux-firmware-iwlwifi-8265 \
"

DEMO_APPS = "\
    ${@oe.utils.conditional('QT_PROVIDER', 'qt5', '', 'wpa-gui-e', d)} \
"

BLUETOOTH_STACK = "\
    bluez5 \
    bluez5-obex \
    bluez5-noinst-tools \
    bluez5-testtools \
    uim \
    bt-enable \
    pulseaudio \
    pulseaudio-server \
    pulseaudio-module-loopback \
    pulseaudio-module-bluetooth-discover \
    pulseaudio-module-bluetooth-policy \
    pulseaudio-module-bluez5-device \
    pulseaudio-module-bluez5-discover \
    pulseaudio-lib-bluez5-util \
    sbc \
"

CONNECTIVITY_RDEPENDS = " \
    htop \
    iptables \
    iproute2 \
    iproute2-tc \
    net-snmp \
"

CONNECTIVITY_RDEPENDS_append_ti33x = "\
    ${WLAN_COMMON} \
    ${DEMO_APPS} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
"

CONNECTIVITY_RDEPENDS_append_ti43x = "\
    ${WLAN_COMMON} \
    ${DEMO_APPS} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
"

CONNECTIVITY_RDEPENDS_append_dra7xx = "\
    ${WLAN_COMMON} \
    ${BLUETOOTH_STACK} \
    ${FIRMWARE_AND_DRIVERS} \
"

RDEPENDS_${PN} = "\
    ${CONNECTIVITY_RDEPENDS} \
"
