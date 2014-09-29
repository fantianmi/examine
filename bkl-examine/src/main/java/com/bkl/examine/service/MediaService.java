package com.bkl.examine.service;

import java.util.List;
import com.bkl.examine.entity.Media;

/**
 * 媒体库服务层
 * @author fanti_000
 *
 */

public interface MediaService {
	public long saveMedia(Media media);
	public long updateMedia(Media media,int id);
	public List<Media> getMediaListByType(int type);
	public List<Media> getMediaList();
	public Media getMedia(int id);
}
