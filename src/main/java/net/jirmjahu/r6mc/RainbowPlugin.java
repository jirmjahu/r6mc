package net.jirmjahu.r6mc;

import lombok.Getter;
import net.jirmjahu.r6mc.cam.CamManager;
import net.jirmjahu.r6mc.cam.CamManagerImpl;
import net.jirmjahu.r6mc.command.TestCommand;
import net.jirmjahu.r6mc.listener.PlayerJoinListener;
import net.jirmjahu.r6mc.listener.PlayerMoveListener;
import net.jirmjahu.r6mc.player.GamePlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class RainbowPlugin extends JavaPlugin {

    private GamePlayerManager gamePlayerManager;
    private CamManager camManager;

    @Override
    public void onEnable() {
        this.gamePlayerManager = new GamePlayerManager();
        this.camManager = new CamManagerImpl();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(gamePlayerManager), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(gamePlayerManager), this);

        getCommand("test").setExecutor(new TestCommand(this));
    }
}