package com.sychev.kmp_sample.core.domain.store.effect

import com.sychev.kmp_sample.core.domain.store.intent.Intent

data class EffectTree internal constructor(
    val effects: List<Effect> = listOf()
) {

    class EffectThreeBuilder {
        private val _effects: MutableList<Effect> = ArrayList()

        fun <I : Intent> addEffect(intent: I, action: (I) -> Unit) {
            _effects.add(
                Effect(
                    intent,
                ) { action(intent) }
            )
        }

        internal fun build() = EffectTree(_effects)
    }

}

fun buildEffects(receiver: EffectTree.EffectThreeBuilder.() -> Unit): EffectTree {
    val builder = EffectTree.EffectThreeBuilder()
    receiver.invoke(builder)
    return builder.build()
}