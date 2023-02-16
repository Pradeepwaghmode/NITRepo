package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nt.modul.Actor;

@Controller
public class ActorConsumerController {

	@Autowired
	private RestTemplate template;
	@Autowired
	private Environment env;

	@GetMapping
	public String showHome() {
		return "home";
	}

	/*
	 * provider url :: http://localhost:8080/SpringRestProj16-ProviderApplicationActor/actor/api/get
	 * req Method/mode :: Get
	 * path variables :: no
	 * response content type ::application/json (default)
	 * request headers :: no
	 * request body type :: no
	 */
	@GetMapping("/actor_report")
	public String getAllActors(Map<String, Object> map) throws Exception {
		String url = env.getProperty("featchAllActor.service.url");
		// invoke provider method using exchange method
		ResponseEntity<String> res = template.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println("Body::" + res.getBody());
		System.out.println("status::" + res.getStatusCode() + " " + res.getStatusCodeValue());
		System.out.println("headres:: " + res.getHeaders());
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list = mapper.readValue(res.getBody(), new TypeReference<List<Actor>>() {
		});
		list.forEach(System.out::println);
		map.put("actorInfo", list);

		return "report";
	}

	/*
	 * provider url :: http://localhost:8080/SpringRestProj16-ProviderApplicationActor/actor/api/get/{id}
	 * req Method/mode :: Get
	 * path variables :: {id}
	 * response content type ::application/json (default)
	 * request headers :: no
	 * request body type :: no
	 */
	@GetMapping("/edit")
	public String editActorFormPage(@RequestParam String actid, @ModelAttribute(name = "actor") Actor act)
			throws Exception {
		System.out.println("=========" + actid);
		String url = env.getProperty("getByid.service.url");
		// invoke provider method using exchange method
		ResponseEntity<String> res = template.exchange(url, HttpMethod.GET, null, String.class, Map.of("id", actid));
		System.out.println("Body::" + res.getBody());
		System.out.println("status::" + res.getStatusCode() + "-- " + res.getStatusCodeValue());
		System.out.println("headres:: " + res.getHeaders());
		ObjectMapper mapper = new ObjectMapper();
		Actor act1 = mapper.readValue(res.getBody(), Actor.class);
		BeanUtils.copyProperties(act1, act);
		System.out.println("=====================");
		System.out.println(act);
		System.out.println("=====================");

		return "edit_page";
	}

	/*
	 * provider url :: http://localhost:8080/SpringRestProj16-ProviderApplicationActor/actor/api/update
	 * req Method/mode :: Update
	 * path variables :: no
	 * response content type ::application/json (default)
	 * request headers :: no
	 * request body type :: actor object as json content
	 */
	@PostMapping("/edit")
	public String editActor(@ModelAttribute(name = "actor") Actor act,RedirectAttributes atr) throws Exception {

		String url = env.getProperty("update.service.url");
		// invoke provider method using exchange method

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(act);
		HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, header);

		ResponseEntity<String> res = template.exchange(url, HttpMethod.PUT, httpEntity, String.class);
		System.out.println("Body::" + res.getBody());
		System.out.println("status::" + res.getStatusCode() + "-- " + res.getStatusCodeValue());
		System.out.println("headres:: " + res.getHeaders());
		atr.addFlashAttribute("msg",res.getBody());
		return "redirect:actor_report";
	}
	
	/*
	 * provider url :: http://localhost:8080/SpringRestProj16-ProviderApplicationActor/actor/api/get/{id}
	 * req Method/mode :: Update
	 * path variables :: {id}
	 * response content type ::plain text
	 * request headers :: no
	 * request body type :: no
	 */
	@GetMapping("/delete")
	public String deleteActorById(@RequestParam String actid,RedirectAttributes  atr)
			throws Exception {
		System.out.println("=========" + actid);
		String url = env.getProperty("delete.service.url");
		// invoke provider method using exchange method
		ResponseEntity<String> res = template.exchange(url, HttpMethod.DELETE, null, String.class, Map.of("id", actid));
		System.out.println("Body::" + res.getBody());
		System.out.println("status::" + res.getStatusCode() + "-- " + res.getStatusCodeValue());
		System.out.println("headres:: " + res.getHeaders());
		atr.addFlashAttribute("msg",res.getBody());
		return "redirect:actor_report";
	}
	@GetMapping("/save")
	public String showRegisractionForm(@ModelAttribute(name = "actor") Actor act) throws Exception {
		return "register_page";
	}
	
	
	/*
	 * provider url :: http://localhost:8080/SpringRestProj16-ProviderApplicationActor/actor/api/save
	 * req Method/mode :: Post
	 * path variables :: no
	 * response content type ::text/plain
	 * request headers :: application/json (default)
	 * request body type :: actor object as json
	 */
	@PostMapping("/save")
	public String rgisterActor(@ModelAttribute(name = "actor") Actor act,Map<String,Object> map,RedirectAttributes atr) throws Exception {

		String url = env.getProperty("save.service.url");
		// invoke provider method using exchange method

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = Obj.writeValueAsString(act);
		HttpEntity<String> httpEntity = new HttpEntity<String>(jsonStr, header);

		ResponseEntity<String> res = template.exchange(url, HttpMethod.POST, httpEntity, String.class);
		System.out.println("Body::" + res.getBody());
		System.out.println("status::" + res.getStatusCode() + "-- " + res.getStatusCodeValue());
		System.out.println("headres:: " + res.getHeaders());
		//map.put("msg", res.getBody());
		//return "forward:actor_report"; can not be forwaird into get mode req usrl so not allowed
		
		atr.addFlashAttribute("msg",res.getBody());
		return "redirect:actor_report";
	}
	
	
}
