#SetPrefix Checklist
* Main Command
    * check if user has perms
        * metatokens.setprefix and metatokens.setsuffix (metatokens.commands)
    ####Might hold off on CC
    * command cooldown
        * hashmap for 6 hours (wish i could persist on server restart)
        * could also use unix timestamp i guess..
    * Check the amount of arguments
        * if less than 1, return usage
        * else continue
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
        * Check token amount
          * if less than 1, return
          * else send processed information to luckperms
          * remove 1 token from balance
          * add processed information to a list in config
            * (will use for later when adding gui)