package net.jirmjahu.r6mc.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.jirmjahu.r6mc.cam.Cam;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

@Getter
@RequiredArgsConstructor
public class GamePlayer {

    private final Player player;
    private boolean isInCam = false;

    public void enterCam(Cam cam) {
        isInCam = true;

        Location playerLocation = player.getLocation();

        ArmorStand playerDummy = (ArmorStand) player.getWorld().spawnEntity(playerLocation, EntityType.ARMOR_STAND);
        playerDummy.customName(Component.text(player.getName()));
        playerDummy.setCustomNameVisible(true);
        playerDummy.setInvulnerable(false);
        playerDummy.setGravity(false);
        playerDummy.setArms(true);
        playerDummy.setHelmet(new ItemStack(Material.PLAYER_HEAD));

        playerDummy.teleport(playerLocation);

        player.addPotionEffect(PotionEffectType.INVISIBILITY.createEffect(100, 200));
        player.teleport(cam.getLocation().add(0, 1, 0));
    }

    public void leaveCam() {

    }

}
