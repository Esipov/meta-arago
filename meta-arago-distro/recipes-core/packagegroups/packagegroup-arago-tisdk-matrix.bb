DESCRIPTION = "Task to include Matrix v2"
LICENSE = "MIT"
PR = "r62"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

MATRIX_ESSENTIALS = "        \
    matrix-gui               \
    matrix-lighttpd-config   \
"

MATRIX_GUI = "               \
    refresh-screen           \
    matrix-gui-browser       \
"

MATRIX_GUI_keystone = ""

MATRIX_COMMON_APPS = "              \
    matrix-gui-armbenchmarks-demos  \
    matrix-gui-crypto-demos         \
    matrix-gui-oprofile-demos       \
    matrix-gui-settings-demos       \
    matrix-gui-usb-demos            \
    matrix-gui-submenus-ethernet    \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'matrix-gui-weston-terminal-demo', '', d)} \
"

#    matrix-gui-thermostat-demo
MATRIX_QT_APPS = " \
    matrix-gui-qt5-demos \
"

MATRIX_TOUCH_APPS = " \
    matrix-gui-touch-demos \
"

MATRIX_QT_APPS_keystone = ""

MATRIX_SGX_DEMOS = " \
    matrix-3d-demo-chameleon \
    matrix-3d-demo-coverflow \
    matrix-3d-demo-navigation \
    matrix-3d-demo-exampleui \
    matrix-3d-demo-kmscube \
"

MATRIX_SGX_DEMOS_append_omap-a15 = " \
    matrix-3d-demo-kmscubevideo \
"

MATRIX_OPENCL_APPS = " \
    matrix-opencl-demo-floatcompute  \
    matrix-opencl-demo-vecadd        \
"

MATRIX_OPENCL_APPS_append_dra7xx = " \
    matrix-video-analytics-opencv-opencl-opengl-demo \
    matrix-machinevision-demo-dlp3dscanner \
"

MATRIX_OPENCV_ARM_ONLY_APPS = " \
     matrix-machinevision-demo-barcoderoi \
"

MATRIX_OPENCV_OPENCL_APPS = " \
    matrix-machinevision-demo-barcoderoi-f2f \
"

MATRIX_OPENCV_OPENCL_APPS_omap-a15 = " \
     matrix-machinevision-demo-barcoderoi \
"

MATRIX_APPS = ""

MATRIX_APPS_append_ti33x = "        \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-audiocapture \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec  \
    matrix-multimedia-demo-mpeg4dec \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
                                    \
    matrix-gui-ethernet-demos       \
                                    \
    ${MATRIX_OPENCV_ARM_ONLY_APPS}  \
"

MATRIX_APPS_append_ti43x = "        \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-h264dec  \
    matrix-multimedia-demo-mpeg4aacdec \
    matrix-multimedia-demo-mpeg4dec \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-pm-demos-suspend     \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
                                    \
    matrix-gui-apps-dual-camera     \
    matrix-gui-apps-image-gallery   \
                                    \
    ${MATRIX_OPENCV_ARM_ONLY_APPS}  \
"

MATRIX_APPS_append_omap-a15 = "     \
    matrix-multimedia-demo-aac      \
    matrix-multimedia-demo-h265dec  \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264dec','matrix-multimedia-demo-h264dec',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-ivahdh264enc','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','matrix-multimedia-demo-vip-vpe-ivahdmpeg4encdec','',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4aacdec',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','mmip','','matrix-multimedia-demo-mpeg4dec',d)} \
                                    \
    matrix-gui-generic-pm           \
    matrix-gui-clocks               \
    matrix-gui-pm-demos-governor    \
"

MATRIX_APPS_append_dra7xx += " \
    matrix-multimedia-demo-dsp66imgproc \
"

MATRIX_APPS_append_keystone = " \
    matrix-gui-utility-demos    \
    matrix-mc-demo-ipc          \
    matrix-multimedia-demo-dsp66imgproc-f2f \
"

RDEPENDS_${PN} = "        \
    ${MATRIX_ESSENTIALS}  \
    ${MATRIX_GUI}         \
    ${MATRIX_COMMON_APPS} \
    ${MATRIX_QT_APPS}     \
    ${MATRIX_TOUCH_APPS}  \
    ${MATRIX_APPS}        \
    ${@bb.utils.contains('MACHINE_FEATURES','sgx',"${MATRIX_SGX_DEMOS}",'',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','opencl',"${MATRIX_OPENCL_APPS}",'',d)} \
    ${@bb.utils.contains('MACHINE_FEATURES','opencl',"${MATRIX_OPENCV_OPENCL_APPS}",'',d)} \
"
