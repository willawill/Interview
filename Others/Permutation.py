def all_perms(prefix, str):
    if len(str) is 2:
        print prefix
    else:
        for i in range(len(str)):
            all_perms(prefix + str[i], str[0:i]+str[i+1:len(str)])



all_perms('',"love")