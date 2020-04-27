package com.example.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.CleaningRecord;
import com.example.domain.Item;
import com.example.domain.User;
import com.example.dto.cleaningRecord.RegistRecordDto;
import com.example.dto.cleaningRecord.ShowRecordDto;
import com.example.dto.cleaningRecord.RegistRecordUserDto;
import com.example.dto.cleaningRecord.RegistRecordItemDto;
import com.example.service.CleaningRecordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/cleaning-rota")
public class CleaningRecordController {
	
	@Autowired
	CleaningRecordService cleaningRecordService;
		
	/**
	 * 主キーソートアイテム全取得
	 * @return
	 */
	@GetMapping("/item-list")
	public List<Item> findAllItemOrderByItemId() {
		return cleaningRecordService.findAllItemOrderByItemId();
	}
	
	/**
	 * 実行日ソート実行日条件掃除当番表レコード全取得
	 * @param showRecordDto 掃除当番表DTO
	 * @return
	 */
	@GetMapping("/show-record")
	public List<List<CleaningRecord>> findAllByExecutedDateOrderByExecutedDate(
			@ModelAttribute ShowRecordDto showRecordDto) {
		
		// レコード取得
		List<CleaningRecord> cleaningRecords = cleaningRecordService
				.findAllByExecutedDateOrderByExecutedDate(showRecordDto);
				
		// 当月日付取得
		List<LocalDate> monthList = Stream
				.iterate(LocalDate.of(showRecordDto.getExecutedDate().getYear(), showRecordDto.getExecutedDate().getMonth(), 1), 
						day -> day.plusDays(1))
				.limit(showRecordDto.getExecutedDate().lengthOfMonth())
				.collect(Collectors.toList());
		
		// アイテム取得
		List<Item> itemList = findAllItemOrderByItemId();
		
		// 当月掃除当番表レコード設定
		List<List<CleaningRecord>> wholeCleaningRecords = new ArrayList<>();
		for (LocalDate day : monthList) {
			List<CleaningRecord> dayCleaningRecords = new ArrayList<>();
			for (Item dbItem : itemList) {
				boolean hasItem = false;
				for (CleaningRecord dbRecord : cleaningRecords) {
					if (day.equals(dbRecord.getExecutedDate())
							&& dbItem.getItemId().equals(dbRecord.getItem().getItemId())) {
						dayCleaningRecords.add(dbRecord);
						hasItem = true;
						break;
					}
				}
				if (!hasItem) {
					CleaningRecord inputRecord = new CleaningRecord();
					Item inputItem = new Item();
					User inputUser = new User();
					inputRecord.setExecutedDate(day);
					inputItem.setItemId(dbItem.getItemId());
					inputItem.setItemName(dbItem.getItemName());
					inputItem.setItemValue(dbItem.getItemValue());
					inputRecord.setItem(inputItem);
					inputRecord.setUser(inputUser);
					dayCleaningRecords.add(inputRecord);
				}
			}
			wholeCleaningRecords.add(dayCleaningRecords);
		}
		return wholeCleaningRecords;
		
	}
	
	/**
	 * 掃除当番表レコード登録
	 * @param registRecordDto 掃除当番表DTO
	 * @return
	 */
	@GetMapping("/regist-record")
	public Integer registCleaningRecord(
			@ModelAttribute RegistRecordDto registRecordDto) throws Exception {
		ObjectMapper om = new ObjectMapper();
		try {
			RegistRecordItemDto registRecordItemDto = om.readValue(registRecordDto.getItem(), RegistRecordItemDto.class);
			RegistRecordUserDto registRecordUserDto = om.readValue(registRecordDto.getUser(), RegistRecordUserDto.class);
			return cleaningRecordService.registCleaningRecord(registRecordItemDto, registRecordUserDto);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	/**
	 * 掃除当番表レコード取り消し
	 * @param registRecordDto 掃除当番表DTO
	 * @return
	 */
	@GetMapping("/cancel-record")
	public Integer cancelCleaningRecord(
			@ModelAttribute RegistRecordDto registRecordDto) throws Exception {
		ObjectMapper om = new ObjectMapper();
		try {
			RegistRecordItemDto registRecordItemDto = om.readValue(registRecordDto.getItem(), RegistRecordItemDto.class);
			RegistRecordUserDto registRecordUserDto = om.readValue(registRecordDto.getUser(), RegistRecordUserDto.class);
			return cleaningRecordService.cancelCleaningRecord(registRecordItemDto, registRecordUserDto);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	/**
	 * 主キーソート日付条件掃除当番表レコード全取得(Try版)
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
