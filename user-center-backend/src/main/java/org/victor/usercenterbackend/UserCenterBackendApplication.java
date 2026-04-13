package org.victor.usercenterbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.victor.usercenterbackend.mapper")
public class UserCenterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterBackendApplication.class, args);
		System.out.println("                                  ___                                     ,--,    \n" +
				"       ,---.  ,--,              ,--.'|_                                 ,--.'|    \n" +
				"      /__./|,--.'|              |  | :,'   ,---.    __  ,-.       ,----,|  | :    \n" +
				" ,---.;  ; ||  |,               :  : ' :  '   ,'\\ ,' ,'/ /|     .'   .`|:  : '    \n" +
				"/___/ \\  | |`--'_       ,---. .;__,'  /  /   /   |'  | |' |  .'   .'  .'|  ' |    \n" +
				"\\   ;  \\ ' |,' ,'|     /     \\|  |   |  .   ; ,. :|  |   ,',---, '   ./ '  | |    \n" +
				" \\   \\  \\: |'  | |    /    / ':__,'| :  '   | |: :'  :  /  ;   | .'  /  |  | :    \n" +
				"  ;   \\  ' .|  | :   .    ' /   '  : |__'   | .; :|  | '   `---' /  ;--,'  : |__  \n" +
				"   \\   \\   ''  : |__ '   ; :__  |  | '.'|   :    |;  : |     /  /  / .`||  | '.'| \n" +
				"    \\   `  ;|  | '.'|'   | '.'| ;  :    ;\\   \\  / |  , ;   ./__;     .' ;  :    ; \n" +
				"     :   \\ |;  :    ;|   :    : |  ,   /  `----'   ---'    ;   |  .'    |  ,   /  \n" +
				"      '---\" |  ,   /  \\   \\  /   ---`-'                    `---'         ---`-'   \n" +
				"             ---`-'    `----'                                                     \n");
	}
}
