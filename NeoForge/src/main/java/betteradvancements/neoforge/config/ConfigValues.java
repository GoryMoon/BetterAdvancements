package betteradvancements.neoforge.config;

import betteradvancements.advancements.BetterDisplayInfo;
import betteradvancements.gui.BetterAdvancementTabType;
import betteradvancements.gui.BetterAdvancementsScreen;
import betteradvancements.gui.BetterAdvancementTab;
import betteradvancements.gui.BetterAdvancementsScreenButton;
import betteradvancements.util.ColorHelper;
import betteradvancements.util.CriteriaDetail;
import betteradvancements.util.CriterionGrid;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigValues {

    public static ModConfigSpec.ConfigValue<String> defaultUncompletedIconColor;
    public static ModConfigSpec.ConfigValue<String> defaultUncompletedTitleColor;
    public static ModConfigSpec.ConfigValue<String> defaultCompletedIconColor;
    public static ModConfigSpec.ConfigValue<String> defaultCompletedTitleColor;

    public static ModConfigSpec.BooleanValue doFade;
    public static ModConfigSpec.BooleanValue showDebugCoordinates;
    public static ModConfigSpec.BooleanValue orderTabsAlphabetically;
    public static ModConfigSpec.IntValue uiScaling;

    public static ModConfigSpec.ConfigValue<String> detailLevel;
    public static ModConfigSpec.BooleanValue requiresShift;
    public static ModConfigSpec.BooleanValue addToInventory;

    public static ModConfigSpec.BooleanValue defaultDrawDirectLines;
    public static ModConfigSpec.BooleanValue defaultHideLines;
    public static ModConfigSpec.ConfigValue<String> defaultCompletedLineColor;
    public static ModConfigSpec.ConfigValue<String>  defaultUncompletedLineColor;

    public static ModConfigSpec.BooleanValue onlyUseAboveAdvancementTabs;

    public static ModConfigSpec build() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        defaultUncompletedIconColor = builder.define("defaultUncompletedIconColor", BetterDisplayInfo.defaultMinecraftUncompletedIconColor);
        defaultUncompletedTitleColor = builder.define("defaultUncompletedTitleColor", BetterDisplayInfo.defaultMinecraftUncompletedTitleColor);
        defaultCompletedIconColor = builder.define("defaultCompletedIconColor", BetterDisplayInfo.defaultMinecraftCompletedIconColor);
        defaultCompletedTitleColor = builder.define("defaultCompletedTitleColor", BetterDisplayInfo.defaultMinecraftCompletedTitleColor);

        doFade = builder.define("doAdvancementsBackgroundFade", true);
        showDebugCoordinates = builder.define("showDebugCoordinates", false);
        orderTabsAlphabetically = builder.define("orderTabsAlphabetically", false);
        uiScaling = builder.comment("Values below 50% might give odd results, use on own risk ;)").defineInRange("uiScaling", 100, 1, 100);

        detailLevel = builder.comment(CriteriaDetail.comments()).defineInList("criteriaDetail", CriteriaDetail.DEFAULT.getName(), CriteriaDetail.names());
        requiresShift = builder.define("criteriaDetailRequiresShift", false);
        addToInventory = builder.define("addInventoryButton", false);

        defaultDrawDirectLines = builder.define("defaultDrawDirectLines", false);
        defaultHideLines = builder.define("defaultHideLines", false);
        defaultCompletedLineColor = builder.define("defaultCompletedLineColor", "#FFFFFF");
        defaultUncompletedLineColor = builder.define("defaultUncompletedLineColor", "#FFFFFF");

        onlyUseAboveAdvancementTabs = builder.define("onlyUseAboveAdvancementTabs", false);

        return builder.build();
    }

    public static void pushChanges() {
        BetterDisplayInfo.defaultUncompletedIconColor = ColorHelper.RGB(defaultUncompletedIconColor.get());
        BetterDisplayInfo.defaultUncompletedTitleColor = ColorHelper.RGB(defaultUncompletedTitleColor.get());
        BetterDisplayInfo.defaultCompletedIconColor = ColorHelper.RGB(defaultCompletedIconColor.get());
        BetterDisplayInfo.defaultCompletedTitleColor = ColorHelper.RGB(defaultCompletedTitleColor.get());

        BetterAdvancementTab.doFade = doFade.get();
        BetterAdvancementsScreen.showDebugCoordinates = showDebugCoordinates.get();
        BetterAdvancementsScreen.orderTabsAlphabetically = orderTabsAlphabetically.get();
        BetterAdvancementsScreen.uiScaling = uiScaling.get();

        CriterionGrid.detailLevel = CriteriaDetail.fromName(detailLevel.get());
        CriterionGrid.requiresShift = requiresShift.get();
        BetterAdvancementsScreenButton.addToInventory = addToInventory.get();

        BetterDisplayInfo.defaultDrawDirectLines = defaultDrawDirectLines.get();
        BetterDisplayInfo.defaultHideLines = defaultHideLines.get();
        BetterDisplayInfo.defaultCompletedLineColor = ColorHelper.RGB(defaultCompletedLineColor.get());
        BetterDisplayInfo.defaultUncompletedLineColor = ColorHelper.RGB(defaultUncompletedLineColor.get());

        BetterAdvancementTabType.onlyUseAbove = onlyUseAboveAdvancementTabs.get();
    }
}
