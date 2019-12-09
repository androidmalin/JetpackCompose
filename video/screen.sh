adb shell screenrecord --time-limit 6 --verbose /sdcard/input_file.mp4 && \
adb pull /sdcard/input_file.mp4
sleep 3
ffmpeg -i input_file.mp4 -acodec copy -vcodec copy -f mov output_file.mov
