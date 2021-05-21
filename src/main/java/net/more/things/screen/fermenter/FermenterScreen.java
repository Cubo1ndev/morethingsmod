package net.more.things.screen.fermenter;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FermenterScreen extends HandledScreen<FermenterScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("morethings", "textures/gui/destiladora.png");

    public FermenterScreen(FermenterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

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

        Slot bottel_slot = ((FermenterScreenHandler)this.handler).getBottleSlot();
        if (!bottel_slot.hasStack()) {
           this.drawTexture(matrices, this.x + bottel_slot.x, this.y + bottel_slot.y, 219, 9, 16, 16);
        }

        Slot output_slot = ((FermenterScreenHandler)this.handler).getOutputSlot();
        if (!output_slot.hasStack()) {
           this.drawTexture(matrices, this.x + output_slot.x, this.y + output_slot.y, 237, 9, 18, 18);
        }

        int i = ((FermenterScreenHandler) this.handler).getDel0();
        int j = ((FermenterScreenHandler) this.handler).getDel1();
        int k = ((FermenterScreenHandler) this.handler).getDel2();
        int l = ((FermenterScreenHandler) this.handler).getDel3();

        int m;
        if (i > 0) {
            if (j == 0)
                j = 200;
            m = i * 13 / j;
            this.drawTexture(matrices, x + 31, y + 38 + 12 - m, 176, 12 - m, 14, m + 1);
        }

        m = l != 0 && k != 0 ? k * 65 / l : 0;
        if (m > 0) {
            this.drawTexture(matrices, x + 71, y + 30, 190, 0, m + 1, 8);

            j = m * l / 64;
            i = l / 2;
            if (j <= i) {
                m = k * 74 / i;
                this.drawTexture(matrices, x + 70, y + 23, 181, 29, m + 1, 25);
            } else if (j > i) {
                j = (k - i) * 74 / i;
                m = 75 - j;
                this.drawTexture(matrices, x + 70 + 74 - m, y + 23, 181 + 74 - m, 29, m + 1, 25);
            }
        }
    }
}