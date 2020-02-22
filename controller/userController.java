package kr.co.corners.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.corners.model.ReturnMsg;
import kr.co.corners.model.SiteModel;
import kr.co.corners.service.SiteService;

@RestController
@RequestMapping("Site")
public class SiteController {
    @Autowired
    SiteService siteService;
    
    /**
     * SVC-00301001 : 사이트정보 추가
     * @param model
     * @return
     */
	@ResponseBody
	@RequestMapping(value="", method={RequestMethod.POST})
	public ReturnMsg appendSite(@RequestBody SiteModel model) {
		return siteService.appendSite(model);
	}
	

	/**
     * SVC-00302002 : 사이트정보 수정
     * @param model
     * @return
     */
	@ResponseBody
	@RequestMapping(value="", method={RequestMethod.PUT})
	public ReturnMsg modifySite(@RequestBody SiteModel model) {
		return siteService.modifySite(model);
	}
	
    /**
     * SVC-00303001 : 사이트 정보를 제외한 모든 정보 삭제
     * @return
     */

    /**
     * SVC-00304001 : 사이트 목록 조회
     * @return
     */
	@ResponseBody
	@RequestMapping(value="/List", method={RequestMethod.GET})
	public ReturnMsg getSiteList(@RequestParam("name") String name){
		return siteService.getSiteList(name);
	}
	
	/**
	 * SVC-00304002 : 사이트 조회
	 * @param siteId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/Info/{siteId}", method={RequestMethod.GET})
	public ReturnMsg getSiteInfo1(@PathVariable int siteId){
		return siteService.getSiteInfo(siteId);
	}
	
	
}
