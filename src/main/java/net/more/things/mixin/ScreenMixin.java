package net.more.things.mixin;

import java.util.List;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

@Mixin(Screen.class)
public abstract class ScreenMixin {
    @Shadow public int height;
    @Shadow public int width;
    @Shadow protected abstract <T extends AbstractButtonWidget> T addButton(T button);
    @Shadow @Final protected List<Element> children;
    @Shadow @Final protected List<AbstractButtonWidget> buttons;
    
    @Unique private AbstractButtonWidget bugReportButton = null;

    @Inject(at = @At("HEAD"), method = "addButton", cancellable = true)
    public void addButtonInject(AbstractButtonWidget button, CallbackInfoReturnable<?> callback) {
        Text message = button.getMessage();

        if ((Object)this instanceof TitleScreen) {
            if (button.y <= (this.height / 4 + 48 + 24 * 3) - 12) {
                button.y += 12;
            } else {
                if (button.y > (this.height / 4 + 48 + 24 * 3) + 12) {
                    button.y -= 12;
                }
            }
        }

        /*if (message.equals(new TranslatableText("modmenu.title").append(new LiteralText(" ")).append(new TranslatableText("modmenu.loaded", ModMenu.getDisplayedModCount())))) {
            button.y -= 24;
            button.x = this.width / 2 + 2;
            button.setWidth(98);
            button.setMessage(new TranslatableText("modmenu.title"));
        }*/
        if (message.equals(new TranslatableText("menu.multiplayer"))){
            button.x = (width / 2) - 100;
            button.y = (height / 2) - 10;
        }
        if (message.equals(new TranslatableText("menu.options")) && (Object)this instanceof TitleScreen){
            button.x = (width / 2) - 100;
            button.y = (height / 2) + 15;
            button.setWidth(200);
        }
        
        if (message.equals(new TranslatableText("menu.quit"))){
            button.x = (width / 2) - 100;
            button.y = (height / 2) + 40;
            button.setWidth(200);
        }
        
        if (message.equals(new TranslatableText("selectServer.refresh"))){
            button.x = (width / 2) - 100;
            button.y = height - 50;
            button.setWidth(200);
        }
        
        if (message.equals(new TranslatableText("gui.cancel")) && (Object)this instanceof MultiplayerScreen){
            button.x = (width / 2) - 100;
            button.y = height - 25;
            button.setWidth(200);
        }


        if (message.equals(new TranslatableText("menu.singleplayer"))) button.visible = true; // at finish check this!!
        if (message.equals(new TranslatableText("menu.online"))) button.visible = false;
        if (message.equals(new TranslatableText("narrator.button.language"))) button.visible = false;
        if (message.equals(new TranslatableText("narrator.button.accessibility"))) button.visible = false;
        if (message.equals(new TranslatableText("selectServer.add"))) button.visible = false;
        if (message.equals(new TranslatableText("selectServer.direct"))) button.visible = false;
        if (message.equals(new TranslatableText("selectServer.select"))) button.visible = false;
        if (message.equals(new TranslatableText("selectServer.edit"))) button.visible = false;
        if (message.equals(new TranslatableText("selectServer.delete"))) button.visible = false;
    }
}