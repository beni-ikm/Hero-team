package Runtime.hero.application.Create;

import Runtime.hero.application.port.HeroRepository;
import Runtime.hero.domain.HeroFactory;

public class HeroCreationUseCase {

    private final HeroRepository heroRepository;

    private final HeroFactory heroFactory;

    public HeroCreationUseCase(
            HeroRepository heroRepository,
            HeroFactory heroFactory
    ){
        this.heroRepository = heroRepository;
        this.heroFactory = heroFactory;
    }

//    public Hero execute(HeroCreationCommand command) {
//        if (heroRepository.isNameTaken(command.name())){
//            throw new HeroNameAlreadyUsedException(command.name());
//        }
//
//        HeroCreationArgs heroArgs = new HeroCreationAssembler().toArgs(command);
//
//        Hero hero = heroFactory.create(heroArgs);
//
//        heroRepository.save(hero);
//
//        return hero;
//    }

}
