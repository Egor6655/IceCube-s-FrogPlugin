package org.icecube.customentities;

import com.ticxo.modelengine.api.ModelEngineAPI;
import com.ticxo.modelengine.api.model.ActiveModel;
import com.ticxo.modelengine.api.model.ModeledEntity;
import com.ticxo.modelengine.api.mount.controller.MountControllerTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Zombie;
import org.jetbrains.annotations.NotNull;

public class CommandListener implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player) {
            Player p = ((Player) sender).getPlayer();
            assert p != null;
            Zombie frog = p.getLocation().getWorld().spawn(p.getLocation(), Zombie.class);
            frog.setCanBreakDoors(true);
            frog.setInvisible(true);
            ModeledEntity modeledEntity = ModelEngineAPI.createModeledEntity(frog);
            ActiveModel model = ModelEngineAPI.createActiveModel("negr");
            modeledEntity.addModel(model,true);
            model.setCanHurt(true);
            model.getMountManager().ifPresent(mountManager -> {
                mountManager.mountDriver(frog, MountControllerTypes.WALKING);
            });



        }
        return true;
    }
}
