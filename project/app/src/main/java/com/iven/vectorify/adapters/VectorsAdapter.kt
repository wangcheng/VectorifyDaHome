package com.iven.vectorify.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.iven.vectorify.R
import com.iven.vectorify.mVectorifyPreferences

class VectorsAdapter : RecyclerView.Adapter<VectorsAdapter.VectorsHolder>() {

    var onVectorClick: ((Int?) -> Unit)? = null

    //first = background color, second = vector color
    private val mVectors = listOf(
        //from https://material.io/resources/icons
        //and
        //https://materialdesignicons.com/

        //android or tech related
        R.drawable.android,
        R.drawable.android_debug_bridge,
        R.drawable.android_head,
        R.drawable.l,
        R.drawable.m_original,
        R.drawable.n_original,
        R.drawable.o_original,
        R.drawable.p,
        R.drawable.q,
        R.drawable.android_studio,
        R.drawable.github_face,
        R.drawable.linux,
        R.drawable.gitlab,
        R.drawable.ladybug,
        R.drawable.fingerprint,
        R.drawable.bug,
        R.drawable.posp,
        R.drawable.posp_alt,
        R.drawable.robot,
        R.drawable.google_cardboard,
        R.drawable.memory,
        R.drawable.gesture,
        R.drawable.touch,
        R.drawable.email,
        R.drawable.navigation,
        R.drawable.place,
        R.drawable.map_marker_check,
        R.drawable.alarm,

        //figures and symbols
        R.drawable.dot,
        R.drawable.origin,
        R.drawable.triangle_inverted,
        R.drawable.grade,
        R.drawable.hearth_border,
        R.drawable.heart,
        R.drawable.heart_multiple,
        R.drawable.heart_pulse,
        R.drawable.charity,
        R.drawable.bubble,
        R.drawable.yin_yang,
        R.drawable.flash,
        R.drawable.fire,
        R.drawable.sticker,
        R.drawable.ampersand,
        R.drawable.money,
        R.drawable.euro,
        R.drawable.gbp,
        R.drawable.cny,

        //animals
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.dog_side,
        R.drawable.pets,
        R.drawable.fish,
        R.drawable.cow,
        R.drawable.rabbit,
        R.drawable.sheep,
        R.drawable.owl,
        R.drawable.panda,
        R.drawable.penguin,
        R.drawable.pig,
        R.drawable.pig_variant,
        R.drawable.tortoise,
        R.drawable.turtle,
        R.drawable.elephant,
        R.drawable.donkey,
        R.drawable.duck,
        R.drawable.bee_flower,
        R.drawable.jellyfish,

        //emoticons
        R.drawable.face,
        R.drawable.emoticon,
        R.drawable.emoticon_cool,
        R.drawable.emoticon_excited,
        R.drawable.emoticon_happy,
        R.drawable.emoticon_tongue,
        R.drawable.emoticon_poop,
        R.drawable.sentiment_very_satisfied,
        R.drawable.child,
        R.drawable.sticker_emoji,
        R.drawable.star_face,
        R.drawable.alien,

        //let's have fun, parties and relax
        R.drawable.toys,
        R.drawable.category,
        R.drawable.drawing,
        R.drawable.gamepad,
        R.drawable.videogame,
        R.drawable.puzzle,
        R.drawable.beach,
        R.drawable.waves,
        R.drawable.island,
        R.drawable.sailing,
        R.drawable.lifebuoy,
        R.drawable.ship_wheel,
        R.drawable.balloon,

        //food
        R.drawable.ice_pop,
        R.drawable.ice_cream,
        R.drawable.cookie,
        R.drawable.food_croissant,
        R.drawable.coffee,
        R.drawable.coffee_outline,
        R.drawable.tea,
        R.drawable.tea_outline,
        R.drawable.cupcake,
        R.drawable.cake,
        R.drawable.lollipop,
        R.drawable.pizza,
        R.drawable.hamburger,
        R.drawable.grill,
        R.drawable.soda,
        R.drawable.bar,
        R.drawable.chef_hat,
        R.drawable.fastfood,
        R.drawable.restaurant,
        R.drawable.rice,
        R.drawable.sausage,
        R.drawable.baguette,
        R.drawable.chili_mild,
        R.drawable.corn,
        R.drawable.mushroom,
        R.drawable.food_apple,
        R.drawable.cherries,
        R.drawable.grapes,
        R.drawable.watermelon,
        R.drawable.carrot,

        //nature
        R.drawable.nature,
        R.drawable.nature_people,
        R.drawable.pine_tree,
        R.drawable.cactus,
        R.drawable.flower_poppy,
        R.drawable.flower,
        R.drawable.flower_tulip,
        R.drawable.tree,
        R.drawable.water,
        R.drawable.leaf,
        R.drawable.sprout,
        R.drawable.barley,
        R.drawable.seed,
        R.drawable.leaf_maple,
        R.drawable.clover,
        R.drawable.wb_sunny,
        R.drawable.cloud,
        R.drawable.cloud_outline,

        //math & greek
        R.drawable.alpha,
        R.drawable.beta,
        R.drawable.gamma,
        R.drawable.delta,
        R.drawable.epsilon,
        R.drawable.lambda,
        R.drawable.pi,
        R.drawable.sigma,
        R.drawable.sigma_lower,
        R.drawable.infinity,
        R.drawable.integral,
        R.drawable.compass,
        R.drawable.angle,

        //science
        R.drawable.periodic_table,
        R.drawable.co2,
        R.drawable.hexagon_outline,
        R.drawable.diamond,
        R.drawable.safety_goggles,
        R.drawable.flask,
        R.drawable.flask_outline,
        R.drawable.flask_empty,
        R.drawable.flask_empty_outline,
        R.drawable.beaker,
        R.drawable.beaker_outline,
        R.drawable.test_tube,
        R.drawable.microscope,
        R.drawable.grain,
        R.drawable.dna,
        R.drawable.radioactive,
        R.drawable.nuke,
        R.drawable.biohazard,
        R.drawable.bacteria,
        R.drawable.atom,
        R.drawable.atom_variant,
        R.drawable.orbit,
        R.drawable.meteor,
        R.drawable.telescope,
        R.drawable.rocket,
        R.drawable.chart_bell_curve,

        //music
        R.drawable.music_note,
        R.drawable.music,
        R.drawable.music_clef_treble,
        R.drawable.headset,
        R.drawable.equalizer,
        R.drawable.speaker,
        R.drawable.guitar_electric,
        R.drawable.violin,
        R.drawable.guitar_pick,
        R.drawable.odnoklassniki,
        R.drawable.saxophone,

        //nerd
        R.drawable.space_invaders,
        R.drawable.ghost,
        R.drawable.one_up,
        R.drawable.pokeball,
        R.drawable.death_star,
        R.drawable.death_star_variant,
        R.drawable.db_tenkaichi,
        R.drawable.kame_sennin_mark,
        R.drawable.dragon_sphere,
        R.drawable.naruto,
        R.drawable.ocarina,

        //buildings
        R.drawable.factory,
        R.drawable.city,
        R.drawable.city_variant,
        R.drawable.city_variant_outline,
        R.drawable.pillar,
        R.drawable.bank,
        R.drawable.stadium,

        //alert
        R.drawable.high,
        R.drawable.help,
        R.drawable.alert,
        R.drawable.alert_outline,
        R.drawable.alert_circle,
        R.drawable.block,
        R.drawable.pan_tool,

        //alphabet
        R.drawable.alpha_a,
        R.drawable.alpha_b,
        R.drawable.alpha_c,
        R.drawable.alpha_d,
        R.drawable.alpha_e,
        R.drawable.alpha_f,
        R.drawable.alpha_g,
        R.drawable.alpha_h,
        R.drawable.alpha_i,
        R.drawable.alpha_j,
        R.drawable.alpha_k,
        R.drawable.alpha_l,
        R.drawable.alpha_m,
        R.drawable.alpha_n,
        R.drawable.alpha_o,
        R.drawable.alpha_p,
        R.drawable.alpha_q,
        R.drawable.alpha_r,
        R.drawable.alpha_s,
        R.drawable.alpha_t,
        R.drawable.alpha_u,
        R.drawable.alpha_v,
        R.drawable.alpha_w,
        R.drawable.alpha_x,
        R.drawable.alpha_y,
        R.drawable.alpha_z,

        //zodiac
        R.drawable.zodiac_aries,
        R.drawable.zodiac_cancer,
        R.drawable.zodiac_capricorn,
        R.drawable.zodiac_gemini,
        R.drawable.zodiac_leo,
        R.drawable.zodiac_libra,
        R.drawable.zodiac_pisces,
        R.drawable.zodiac_sagittarius,
        R.drawable.zodiac_scorpio,
        R.drawable.zodiac_taurus,
        R.drawable.zodiac_virgo,

        //others
        R.drawable.school,
        R.drawable.tie,
        R.drawable.brain,
        R.drawable.thumb_up,
        R.drawable.human_greeting,
        R.drawable.airballoon,
        R.drawable.sunglasses,
        R.drawable.edit,
        R.drawable.paint,
        R.drawable.brush,
        R.drawable.quote,
        R.drawable.weekend,
        R.drawable.ufo
    )

    private var mSelectedDrawable = R.drawable.android

    init {
        mSelectedDrawable = mVectorifyPreferences.vector
    }

    fun swapSelectedDrawable(newSelectedDrawable: Int) {
        notifyItemChanged(getVectorPosition(mSelectedDrawable))
        mSelectedDrawable = newSelectedDrawable
        notifyItemChanged(getVectorPosition(mSelectedDrawable))
    }

    fun getVectorPosition(drawable: Int): Int {
        return try {
            mVectors.indexOf(drawable)
        } catch (e: Exception) {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VectorsHolder {
        return VectorsHolder(LayoutInflater.from(parent.context).inflate(R.layout.vector_option, parent, false))
    }

    override fun getItemCount(): Int {
        return mVectors.size
    }

    override fun onBindViewHolder(holder: VectorsHolder, position: Int) {
        holder.bindItems(mVectors[holder.adapterPosition])
    }

    inner class VectorsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(drawable: Int) {

            val vectorButton = itemView.findViewById<ImageButton>(R.id.vector_button)
            val checkbox = itemView.findViewById<ImageView>(R.id.checkbox)

            vectorButton.setImageResource(drawable)

            if (mSelectedDrawable == drawable) checkbox.visibility = View.VISIBLE
            else
                checkbox.visibility = View.GONE

            vectorButton.setOnClickListener {
                if (mSelectedDrawable != drawable) {
                    notifyItemChanged(getVectorPosition(mSelectedDrawable))
                    mSelectedDrawable = drawable
                    checkbox.visibility = View.VISIBLE
                    onVectorClick?.invoke(drawable)
                }
            }
        }
    }
}
