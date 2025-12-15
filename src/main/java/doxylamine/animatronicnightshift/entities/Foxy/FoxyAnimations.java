package doxylamine.animatronicnightshift.entities.Foxy;// Save this class in your mod and generate all required imports

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

/**
 * Made with Blockbench 5.0.4
 * Exported for Minecraft version 1.19 or later with Mojang mappings
 * @author Author
 */
public class FoxyAnimations {
	public static final AnimationDefinition day = AnimationDefinition.Builder.withLength(0.0F)
		.addAnimation("tete", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("corps", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("brasdroit", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.9979F, -0.1605F, -0.0888F), AnimationChannel.Interpolations.LINEAR)
		))
		.addAnimation("brasgauche", new AnimationChannel(AnimationChannel.Targets.ROTATION, 
			new Keyframe(0.0F, KeyframeAnimations.degreeVec(-4.9697F, 0.5518F, 0.0604F), AnimationChannel.Interpolations.LINEAR)
		))
		.build();
}