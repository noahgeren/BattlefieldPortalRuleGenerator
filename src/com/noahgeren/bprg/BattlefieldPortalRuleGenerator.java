package com.noahgeren.bprg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BattlefieldPortalRuleGenerator {
	
	private BattlefieldPortalRuleGenerator() {}
	
	public static Mod startMod() {
		return new Mod();
	}
	
	public static void exportMod(Mod mod, File file) throws IOException {
		try (FileWriter writer = new FileWriter(file, false)) {
			writer.write(mod.toString());
		}
	}

}
