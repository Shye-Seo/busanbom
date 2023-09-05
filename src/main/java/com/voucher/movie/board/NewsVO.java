package com.voucher.movie.board;

import lombok.Data;

@Data
public class NewsVO {
	
	private int id;
	private String news_title;
	private String news_content;
	private String news_image;
	private String news_link;
	private String news_date;
	private String news_writer;

}
