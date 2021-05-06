package br.com.dev.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dev.model.Developer;
import br.com.dev.repository.DeveloperRepository;





@SpringBootTest
class ServiceTest {
	
	@Mock
	private DeveloperRepository developerRepository;
	
	@InjectMocks
	private DeveloperService developerService;
	
	private static Developer dev;
	
	
	
	@BeforeAll
	static void beforeAll() {
		dev = new Developer();
		dev.setId(1L);
		dev.setLogin("bob");
		dev.setFollowers(5L);
		dev.setPublicRepos(6L);
		
		
	}

	@Test
	@DisplayName("Deve salvar os dados de um desenvolvedor")
	void testSalvarPessoa() {
		when(developerService.obterPorId(1L)).thenReturn(Optional.of(dev));
		when(developerService.salvar(dev)).thenReturn(dev);
		
		Developer newDev = new Developer();
		newDev.setId(5L);
		newDev.setLogin("Lorem Ipsum");
		newDev.setFollowers(34L);
		newDev.setPublicRepos(43L);
		
		
		
		Developer devSalva = developerService.salvar(newDev);
		
		assertAll(() -> {
		
			assertEquals(newDev.getId(), devSalva.getId());
			assertEquals(newDev.getLogin(), devSalva.getLogin());
			assertEquals(newDev.getFollowers(), devSalva.getFollowers());
			assertEquals(newDev.getPublicRepos(), devSalva.getPublicRepos());
		});
	}


}
