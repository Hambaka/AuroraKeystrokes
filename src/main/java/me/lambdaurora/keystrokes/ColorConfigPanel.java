/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of AuroraKeystrokes.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.keystrokes;

import net.minecraft.client.resource.language.I18n;
import org.aperlambda.lambdacommon.utils.Nameable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

/**
 * Represents panels for the color config screen.
 */
public enum ColorConfigPanel implements Nameable
{
    NORMAL(),
    PRESSED() {
        public Color getColor(@NotNull KeystrokesConfig config)
        {
            return config.getColorPressed();
        }

        public void setColor(@NotNull KeystrokesConfig config, @NotNull Color color)
        {
            config.setColorPressed(color);
        }

        public Color getBackgroundColor(@NotNull KeystrokesConfig config)
        {
            return config.getBackgroundPressed();
        }

        public void setBackgroundColor(@NotNull KeystrokesConfig config, @NotNull Color color)
        {
            config.setBackgroundPressed(color);
        }
    };

    public Color getColor(@NotNull KeystrokesConfig config)
    {
        return config.getColorNormal();
    }

    public void setColor(@NotNull KeystrokesConfig config, @NotNull Color color)
    {
        config.setColorNormal(color);
    }

    public Color getBackgroundColor(@NotNull KeystrokesConfig config)
    {
        return config.getBackgroundNormal();
    }

    public void setBackgroundColor(@NotNull KeystrokesConfig config, @NotNull Color color)
    {
        config.setBackgroundNormal(color);
    }

    /**
     * Returns the next color config panel available.
     *
     * @return The next available color config panel.
     */
    public ColorConfigPanel next()
    {
        ColorConfigPanel[] v = values();
        if (v.length == this.ordinal() + 1)
            return v[0];
        return v[this.ordinal() + 1];
    }

    /**
     * Gets the translated name of this color config panel.
     *
     * @return The translated name of this color config panel.
     */
    public String getTranslatedName()
    {
        return I18n.translate("keystrokes.color_config_panel." + this.getName());
    }

    @Override
    public @NotNull String getName()
    {
        return this.name().toLowerCase();
    }
}
