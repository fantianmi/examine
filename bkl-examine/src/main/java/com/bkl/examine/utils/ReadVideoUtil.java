package com.bkl.examine.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import com.km.common.utils.TimeUtil;

public class ReadVideoUtil {
	public static String caculateVideoDuration(File source) {
		Encoder encoder = new Encoder();
		try {
			MultimediaInfo m = encoder.getInfo(source);
			long ls = m.getDuration();
			return TimeUtil.formatDuring(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		File source = new File(
				"D:\\bkltech.workspace\\bkl-examine\\src\\main\\webapp\\upload\\video\\yingyutucao.mp4");
		Encoder encoder = new Encoder();
		try {
			MultimediaInfo m = encoder.getInfo(source);
			long ls = m.getDuration();
			System.out.println("此视频时长为:" + TimeUtil.formatDuring(ls) + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
