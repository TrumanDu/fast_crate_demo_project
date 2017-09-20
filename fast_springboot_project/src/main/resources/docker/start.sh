#!/bin/sh
option=
for arg in "$@"
do
	key=${arg%%=*}
	value=${arg#*=}
	case $key in
	--publicConfig)
		publicConfig=$value
		;;
	*)
		option="$option $key=$value"
		;;
	esac
done

if [ -n $publicConfig ];then
	if wget -O application.yml $publicConfig;then
	echo "echo  run with git application.yml"
     cp application.yml ${BASE_DIR}/config/
	else
	if [ ! -f application.yml ];then
		echo "not find publicConfig application.yml"
		exit 2
	 else
		echo "echo run with cache  application.yml"
	 fi
   fi
fi




java -jar fast_springboot_project-0.0.1-SNAPSHOT.jar   $option
