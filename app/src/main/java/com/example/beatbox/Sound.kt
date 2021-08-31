package com.example.beatbox

private const val WAV = ".wav"

/** We will want the files to be played, so it makes sense to have an object responsible for
 * keeping track of the filename, the name (formatted) the user should see,
 * and any other information related to that sound. */

class Sound(val assetPath: String, var soundId: Int? = null) {

    //FORMATTING THE FILENAME
    /** Split off the filename using String.split().last().
     * Use String.removeSuffix() to strip off the file extension, too. */
    val name = assetPath.split("/").last().removeSuffix(WAV)
}