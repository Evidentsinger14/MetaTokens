[![Build Status](https://ci.ev1dent.dev/buildStatus/icon?job=MetaTokens)](https://ci.ev1dent.dev/job/MetaTokens/)
# (Incomplete)
## Introduction
This plugin is designed to allow players to set Prefixes/Suffixes, based on the amount of "tokens" they have.   

## To do list:
* Prefix/Suffix commands 
  * Check filtered string against regex list
  * optional additions to be added to the final string
  * display final prefix to player + confirmation
  * send complete suffix to LP
  * add support for dynamic list of regex filters (CR Ep11)
* Console command to add/remove meta tokens.
* Gui to display all set prefixes with option to toggle (Probably not any time soon)
* Add hex support? maybe Gradients?


# Command Checklist

## Setprefix and Setsuffix
  * check if blacklisted
    * metatokens.setprefix and metatokens.setsuffix (metatokens.commands)
  * command cooldown
    * hashmap for 6 hours (wish i could persist on server restart)
    * could also use unix timestamp i guess..
  * Check the amount of arguments
    * if less than 1, return usage
    * else continue
  * Check token amount
    * if less than 1, return
    * else continue
  * Setup Filters
    * String RawPrefix = args[0];
    * String Stage1 = config.getString("prefix-layout");
    * String FormattedPrefix = Stage1.replace("{META}", RawPrefix);
    * String Filtered = RawPrefix.replaceAll("(?i)[§&][0-9A-FL-ORX]", "");
    * Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
    * Matcher match = pattern.matcher(Filtered);
  * check if Filtered is on a list of blacklisted words
    * i don't know how, but ill figure it out
  * check if filter is not matched
    * if true return with message (no magic or special characters)
    * if false continue
  * add additions
    * if config value for additions is true
      * add additions
    * if config value for additions is false
      * return rawprefix
    * ask for confirmation (use a hashmap)
      * send prefix to player in chat
  * send processed information to luckperms
  * remove 1 token from balance
  * add processed information to a list in config
    * (will use for later when adding gui)

## Tokens
(need to update)
## MetaTokens
(need to update)
