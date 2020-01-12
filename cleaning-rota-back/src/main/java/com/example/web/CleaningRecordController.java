package com.example.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.CleaningRecord;
import com.example.domain.Item;
import com.example.service.CleaningRecordService;

@RestController
@RequestMapping("/cleaning-rota")
public class CleaningRecordController {
	
	@Autowired
	CleaningRecordService cleaningRecordService;
	
	/**
	 * 主キーソート掃除当番表レコード全取得
	 * @return
	 */
	@GetMapping
	public List<CleaningRecord> findAllOrderByRecordId() {
		return cleaningRecordService.findAllOrderByRecordId();
	}
	
	/**
	 * 主キーソートアイテム全取得
	 * @return
	 */
	@GetMapping("/item-list")
	public List<Item> findAllItemOrderByItemId() {
		return cleaningRecordService.findAllItemOrderByItemId();
	}
	
	/**
	 * 主キーソート日付条件掃除当番表レコード全取得
	 * @param fromDate 検索開始日
	 * @param toDate 検索終了日
	 * @return
	 */
	@GetMapping("/param")
	public List<CleaningRecord> findAllByExecutedDate(
			@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		return cleaningRecordService.findAllByExecutedDateOrderByRecordId(LocalDate.parse(fromDate),
				LocalDate.parse(toDate));
	}

}
