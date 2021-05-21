package net.more.things.screen.advanced_jukebox;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AdvancedJukeboxScreen extends HandledScreen<AdvancedJukeboxScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("morethings", "textures/gui/advanced_jukebock.png");

    public AdvancedJukeboxScreen(AdvancedJukeboxScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    /*public boolean mouseClicked(double mouseX, double mouseY, int button) {
       int i = (this.width - this.backgroundWidth) / 2;
       int j = (this.height - this.backgroundHeight) / 2;
 
       for(int k = 0; k < 3; ++k) {
          double d = mouseX - (double)(i + 60);
          double e = mouseY - (double)(j + 14 + 19 * k);
          if (d >= 0.0D && e >= 0.0D && d < 108.0D && e < 19.0D && ((FermenterScreenHandler)this.handler).onButtonClick(this.client.player, k)) {
             this.client.interactionManager.clickButton(((FermenterScreenHandler)this.handler).syncId, k);
             return true;
          }
       }
 
       return super.mouseClicked(mouseX, mouseY, button);
    }*/
    
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.drawBackground(matrices, delta, mouseX, mouseY);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.client.getTextureManager().bindTexture(TEXTURE);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        /*int l = ((AdvancedJukeboxScreenHandler)this.handler).getTankSize();
        if (l > 0) {
            System.out.print(l);
            this.drawTexture(matrices, x + 100, y + 15 + 59 - l, 176, 73 - l, 12, l + 1);
        }

        l = 0;
        if (((AdvancedJukeboxScreenHandler)this.handler).isBurning()) {
           l = ((AdvancedJukeboxScreenHandler)this.handler).getFuelProgress();
           this.drawTexture(matrices, x + 31, y + 38 + 12 - l, 176, 12 - l, 14, l + 1);
        }

        l = ((AdvancedJukeboxScreenHandler)this.handler).getFermentProgress();
        if (l > 0) {
            this.drawTexture(matrices, x + 70, y + 24, 216, 0, 29, 3);
            this.drawTexture(matrices, x + 71, y + 30, 190, 0, l + 1, 8);
        }*/
    }
}