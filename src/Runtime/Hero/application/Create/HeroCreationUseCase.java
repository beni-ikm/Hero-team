package Runtime.Hero.application.Create;

import Runtime.Hero.application.port.HeroRepository;
import Runtime.Hero.domain.Hero;
import Runtime.Hero.domain.HeroCreationArgs;
import Runtime.Hero.domain.HeroFactory;
import Runtime.Hero.domain.exception.HeroNameAlreadyUsedException;

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
