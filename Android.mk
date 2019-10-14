#
# Copyright (C) 2016 The CyanogenMod Project
#           (C) 2017 The LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

ifneq ($(filter athene, $(TARGET_DEVICE)),)

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

FIRMWARE_MOUNT_POINT := $(TARGET_OUT_VENDOR)/firmware_mnt
$(FIRMWARE_MOUNT_POINT): $(LOCAL_INSTALLED_MODULE)
	@echo "Creating $(FIRMWARE_MOUNT_POINT)"
	@mkdir -p $(TARGET_OUT_VENDOR)/firmware_mnt

DSP_MOUNT_POINT := $(TARGET_OUT_VENDOR)/dsp
$(DSP_MOUNT_POINT): $(LOCAL_INSTALLED_MODULE)
	@echo "Creating $(DSP_MOUNT_POINT)"
	@mkdir -p $(TARGET_OUT_VENDOR)/dsp

FSG_MOUNT_POINT := $(TARGET_OUT_VENDOR)/fsg
$(FSG_MOUNT_POINT): $(LOCAL_INSTALLED_MODULE)
	@echo "Creating $(FSG_MOUNT_POINT)"
	@mkdir -p $(TARGET_OUT_VENDOR)/fsg

ALL_DEFAULT_INSTALLED_MODULES += $(FIRMWARE_MOUNT_POINT) $(DSP_MOUNT_POINT) $(FSG_MOUNT_POINT)

#########################################################################
# Create Folder Structure
#########################################################################

$(shell rm -rf $(TARGET_OUT_VENDOR)/rfs/)

#To be enabled when prepopulation support is needed for the read_write folder
# $(shell rm -rf  $(TARGET_OUT_DATA)/rfs/)
# $(shell mkdir -p $(TARGET_OUT_DATA)/rfs/msm/mpss/)
# $(shell mkdir -p $(TARGET_OUT_DATA)/rfs/msm/adsp/)
# $(shell mkdir -p $(TARGET_OUT_DATA)/rfs/mdm/mpss/)
# $(shell mkdir -p $(TARGET_OUT_DATA)/rfs/mdm/adsp/)

#########################################################################
# MSM Folders
#########################################################################
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/msm/adsp/readonly/vendor)
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/msm/mpss/readonly/vendor)
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/msm/slpi/readonly)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/adsp/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/lpass $(TARGET_OUT_VENDOR)/rfs/msm/adsp/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/msm/adsp/readonly/firmware)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/msm/adsp/readonly/vendor/firmware)
$(shell ln -s /persist/rfs/msm/adsp $(TARGET_OUT_VENDOR)/rfs/msm/adsp/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/adsp/shared)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/mpss/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/modem $(TARGET_OUT_VENDOR)/rfs/msm/mpss/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/msm/mpss/readonly/firmware)
$(shell ln -s /fsg $(TARGET_OUT_VENDOR)/rfs/msm/mpss/readonly/fsg)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/msm/mpss/readonly/vendor/firmware)
$(shell ln -s /persist/rfs/msm/mpss $(TARGET_OUT_VENDOR)/rfs/msm/mpss/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/mpss/shared)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/slpi/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/slpi $(TARGET_OUT_VENDOR)/rfs/msm/slpi/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/msm/slpi/readonly/firmware)
$(shell ln -s /persist/rfs/msm/slpi $(TARGET_OUT_VENDOR)/rfs/msm/slpi/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/msm/slpi/shared)

#########################################################################
# MDM Folders
#########################################################################
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/readonly/vendor)
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/readonly/vendor)
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/readonly/vendor)
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/mdm/tn/readonly/vendor)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/lpass $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/readonly/firmware)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/readonly/vendor/firmware)
$(shell ln -s /persist/rfs/mdm/adsp $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/adsp/shared)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/modem $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/readonly/firmware)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/readonly/vendor/firmware)
$(shell ln -s /persist/rfs/mdm/mpss $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/mpss/shared)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/slpi $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/readonly/firmware)
$(shell ln -s /persist/rfs/mdm/slpi $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/slpi/shared)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/tn/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/tn $(TARGET_OUT_VENDOR)/rfs/mdm/tn/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/mdm/tn/readonly/firmware)
$(shell ln -s /persist/rfs/mdm/tn $(TARGET_OUT_VENDOR)/rfs/mdm/tn/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/mdm/tn/shared)

#########################################################################
# APQ Folders
#########################################################################
$(shell mkdir -p $(TARGET_OUT_VENDOR)/rfs/apq/gnss/readonly/vendor)

$(shell ln -s /persist/hlos_rfs/shared $(TARGET_OUT_VENDOR)/rfs/apq/gnss/hlos)
$(shell ln -s /data/vendor/tombstones/rfs/modem $(TARGET_OUT_VENDOR)/rfs/apq/gnss/ramdumps)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/apq/gnss/readonly/firmware)
$(shell ln -s /firmware $(TARGET_OUT_VENDOR)/rfs/apq/gnss/readonly/vendor/firmware)
$(shell ln -s /persist/rfs/apq/gnss $(TARGET_OUT_VENDOR)/rfs/apq/gnss/readwrite)
$(shell ln -s /persist/rfs/shared $(TARGET_OUT_VENDOR)/rfs/apq/gnss/shared)

include $(call all-makefiles-under,$(LOCAL_PATH))

endif
