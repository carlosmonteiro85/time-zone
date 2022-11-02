package br.com.acme.fakeecomerce.timezone;

import java.util.Locale;

import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

@SpringBootTest
public class TimeZoneApplicationTests {

	protected static Faker faker = Faker.instance(new Locale("pt", "BR"));

}
