package com.example.joblisting.JudgeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@RestController
@RequestMapping(value="job")
public class judgeController {
	
	@GetMapping("/getConfig")
	public String getConfiguration() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://13.233.54.34:2358/config_info"))
				.method("GET", HttpRequest.BodyPublishers.ofString("{\"max_queue_size\": 1000,\"cpu_time_limit\": 5,\"max_cpu_time_limit\": 25,\"cpu_extra_time\": 1,\"max_cpu_extra_time\": 2,\"wall_time_limit\": 10,\"max_wall_time_limit\": 30}"))
				.header("Key", "Value")
				.header("Host", "Cite")
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

	@GetMapping("/getLanguages")
	public String getLanguages() throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://13.233.54.34:2358/languages"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@GetMapping("/getLanguage")
	public String getLanguage() throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://13.233.54.34:2358/languages/91"))
				.header("Key", "Value")
				.header("Host", "Cite")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@GetMapping("/getStatus")
	public String getStatus() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://13.233.54.34:2358/statuses"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@PostMapping("/createSubmission")
	public String createSubmission() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://52.66.242.43:2358/submissions?base64_encoded=true&fields=*"))
				.header("content-type", "application/json").header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString(
						"{\r\n    \"language_id\": 62,\r\n    \"source_code\": \"aW1wb3J0IGphdmEudXRpbC4qOw0KcHVibGljIGNsYXNzIE1haW4gew0KICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluKFN0cmluZ1tdIGFyZ3MpIHsNCiAgICAgICAgCUhhc2hNYXA8Q2hhcmFjdGVyLEludGVnZXI+IG1hcD1uZXcgSGFzaE1hcDw+KCk7DQoJU2Nhbm5lciBzYz1uZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOw0KCVN0cmluZyBzdHI9c2MubmV4dExpbmUoKTsNCgljaGFyIGFycltdPXN0ci50b0NoYXJBcnJheSgpOw0KCWZvcihpbnQgaT0wOyBpPHN0ci5sZW5ndGgoKTsgaS0tKSB7DQoJCWlmKG1hcC5jb250YWluc0tleShhcnJbaV0pKSB7DQoJCQltYXAucHV0KGFycltpXSwgbWFwLmdldChhcnJbaV0pKzEpOw0KCQl9DQoJCWVsc2UNCgkJew0KCQkJbWFwLnB1dChhcnJbaV0sIDEpOw0KCQl9DQoJfQ0KCWZvcihNYXAuRW50cnk8Q2hhcmFjdGVyLEludGVnZXI+IGU6IG1hcC5lbnRyeVNldCgpKQ0KCXsNCgkJaWYoZS5nZXRWYWx1ZSgpPT0xKSB7DQoJCQlTeXN0ZW0ub3V0LnByaW50bG4oZS5nZXRLZXkoKSk7DQoJCX0NCgl9DQoJCX0NCiAgICB9\",\r\n    \"stdin\": \"YWJiYmFj\",\r\n    \"expected_output\": \"Yw==\"\r\n}"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@GetMapping("/getSubmission")
	public String getSubmission() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"http://52.66.242.43:2358/submissions/ca16c01e-9a66-45e7-83b6-f467e33c9081?base64_encoded=true&fields=*"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@PostMapping("/createBatchedSubmissions")
	public String createBatchedSubmissions() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://52.66.242.43:2358/submissions/batch?base64_encoded=true"))
				.header("content-type", "application/json").header("Content-Type", "application/json")
				.method("POST", HttpRequest.BodyPublishers.ofString(
						"{\r\n    \"submissions\": [\r\n        {\r\n            \"language_id\": 62,\r\n            \"source_code\": \"aW1wb3J0IGphdmEudXRpbC4qOw0KcHVibGljIGNsYXNzIE1haW4gew0KICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluKFN0cmluZ1tdIGFyZ3MpIHsNCiAgICAgICAgCUhhc2hNYXA8Q2hhcmFjdGVyLEludGVnZXI+IG1hcD1uZXcgSGFzaE1hcDw+KCk7DQoJU2Nhbm5lciBzYz1uZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOw0KCVN0cmluZyBzdHI9c2MubmV4dExpbmUoKTsNCgljaGFyIGFycltdPXN0ci50b0NoYXJBcnJheSgpOw0KCWZvcihpbnQgaT0wOyBpPHN0ci5sZW5ndGgoKTsgaSsrKSB7DQoJCWlmKG1hcC5jb250YWluc0tleShhcnJbaV0pKSB7DQoJCQltYXAucHV0KGFycltpXSwgbWFwLmdldChhcnJbaV0pKzEpOw0KCQl9DQoJCWVsc2UNCgkJew0KCQkJbWFwLnB1dChhcnJbaV0sIDEpOw0KCQl9DQoJfQ0KCWZvcihNYXAuRW50cnk8Q2hhcmFjdGVyLEludGVnZXI+IGU6IG1hcC5lbnRyeVNldCgpKQ0KCXsNCgkJaWYoZS5nZXRWYWx1ZSgpPT0yKSB7DQoJCQlTeXN0ZW0ub3V0LnByaW50bG4oZS5nZXRLZXkoKSk7DQoJCX0NCgl9DQoJCX0NCiAgICB9\"\r\n    \"stdin\": \"YWJiYmFj\",\r\n    },\r\n        {\r\n            \"language_id\": 62,\r\n            \"source_code\": \"aW1wb3J0IGphdmEudXRpbC4qOw0KcHVibGljIGNsYXNzIE1haW4gew0KICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluKFN0cmluZ1tdIGFyZ3MpIHsNCiAgICAgICAgCUhhc2hNYXA8Q2hhcmFjdGVyLEludGVnZXI+IG1hcD1uZXcgSGFzaE1hcDw+KCk7DQoJU2Nhbm5lciBzYz1uZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOw0KCVN0cmluZyBzdHI9c2MubmV4dExpbmUoKTsNCgljaGFyIGFycltdPXN0ci50b0NoYXJBcnJheSgpOw0KCWZvcihpbnQgaT0wOyBpPHN0ci5sZW5ndGgoKTsgaSsrKSB7DQoJCWlmKG1hcC5jb250YWluc0tleShhcnJbaV0pKSB7DQoJCQltYXAucHV0KGFycltpXSwgbWFwLmdldChhcnJbaV0pKzEpOw0KCQl9DQoJCWVsc2UNCgkJew0KCQkJbWFwLnB1dChhcnJbaV0sIDEpOw0KCQl9DQoJfQ0KCWZvcihNYXAuRW50cnk8Q2hhcmFjdGVyLEludGVnZXI+IGU6IG1hcC5lbnRyeVNldCgpKQ0KCXsNCgkJaWYoZS5nZXR2YWx1ZSgpPT0xKSB7DQoJCQlTeXN0ZW0ub3V0LnByaW50bG4oZS5nZXRLZXkoKSk7DQoJCX0NCgl9DQoJCX0NCiAgICB9\"\r\n    \"stdin\": \"YWJiYmFj\",\r\n            },\r\n        {\r\n            \"language_id\": 62,\r\n            \"source_code\": \"aW1wb3J0IGphdmEudXRpbC4qOw0KcHVibGljIGNsYXNzIE1haW4gew0KICAgIHB1YmxpYyBzdGF0aWMgdm9pZCBtYWluKFN0cmluZ1tdIGFyZ3MpIHsNCiAgICAgICAgCUhhc2hNYXA8Q2hhcmFjdGVyLEludGVnZXI+IG1hcD1uZXcgSGFzaE1hcDw+KCk7DQoJU2Nhbm5lciBzYz1uZXcgU2Nhbm5lcihTeXN0ZW0uaW4pOw0KCVN0cmluZyBzdHI9c2MubmV4dExpbmUoKTsNCgljaGFyIGFycltdPXN0ci50b0NoYXJBcnJheSgpOw0KCWZvcihpbnQgaT0wOyBpPHN0ci5sZW5ndGgoKTsgaS0tKSB7DQoJCWlmKG1hcC5jb250YWluc0tleShhcnJbaV0pKSB7DQoJCQltYXAucHV0KGFycltpXSwgbWFwLmdldChhcnJbaV0pKzEpOw0KCQl9DQoJCWVsc2UNCgkJew0KCQkJbWFwLnB1dChhcnJbaV0sIDEpOw0KCQl9DQoJfQ0KCWZvcihNYXAuRW50cnk8Q2hhcmFjdGVyLEludGVnZXI+IGU6IG1hcC5lbnRyeVNldCgpKQ0KCXsNCgkJaWYoZS5nZXRWYWx1ZSgpPT0xKSB7DQoJCQlTeXN0ZW0ub3V0LnByaW50bG4oZS5nZXRLZXkoKSk7DQoJCX0NCgl9DQoJCX0NCiAgICB9\"\r\n    \"stdin\": \"YWJiYmFj\",\r\n            }\r\n    ]\r\n}"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();

	}

	@GetMapping("/getBatchedSubmissions")
	public String getBatchSubmissions() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
				"http://52.66.242.43:2358/submissions/batch?tokens=cbaeae95-5d87-4e0e-8a25-84142d268b93,68b7bba2-1e00-440f-a6b5-ea3efa0219d4,315fe113-4a94-4c7f-9d52-8ef1c2800df7&base64_encoded=true&fields=*"))
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

}
