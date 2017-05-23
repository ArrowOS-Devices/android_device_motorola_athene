#!/sbin/sh

sku=`getprop ro.boot.hardware.sku`

if ! [ "$sku" = "XT1626" ]; then
    # Only XT1626 variants got DTV support
    rm /system/vendor/lib64/libdtvtuner.so
    rm /system/vendor/bin/hw/motorola.hardware.tv@1.0-service
    rm /system/vendor/etc/init/motorola.hardware.tv@1.0-service.rc
    rm /system/vendor/etc/permissions/com.motorola.hardware.dtv.xml
    rm /system/vendor/etc/permissions/mot_dtv_permissions.xml
    rm /system/vendor/lib/hw/motorola.hardware.tv@1.0-impl.so
    rm /system/vendor/lib/motorola.hardware.tv@1.0.so
    rm /system/vendor/lib/motorola.hardware.tv@1.0_vendor.so
    rm /system/vendor/lib64/hw/motorola.hardware.tv@1.0-impl.so
    rm /system/vendor/lib64/motorola.hardware.tv@1.0.so
    rm /system/vendor/lib64/motorola.hardware.tv@1.0_vendor.so
    rm -r /system/vendor/app/DTVPlayer
    rm -r /system/vendor/app/DTVService
fi
