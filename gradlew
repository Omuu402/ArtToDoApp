#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a link
PRG="$0"
# Need this for relative symlinks.
while [ -h "$PRG" ] ; do
    ls=`ls -ld "$PRG"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        PRG="$link"
    else
        PRG=`dirname "$PRG"`/"$link"
    fi
done
SAVED="`pwd`"
cd "`dirname \"$PRG\"`/" >/dev/null
APP_HOME="`pwd -P`"
cd "$SAVED" >/dev/null

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Use the maximum available, or at least 512M, for the heap size.
if [ -n "$JAVA_OPTS" ] ; then
    case $JAVA_OPTS in
        *-Xmx*) ;;
        *) JAVA_OPTS="$JAVA_OPTS -Xmx512m" ;;
    esac
fi

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/bin/java" ] ; then
        # Java executable found in JAVA_HOME.
        JAVACMD="$JAVA_HOME/bin/java"
    else
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum file descriptors if we can.
if [ "$OS" != "Windows_NT" ] && [ "$OS" != "CYGWIN" ] && [ "$OS" != "MINGW" ] && [ "$OS" != "MSYS" ] ; then
    MAX_FD_LIMIT=`ulimit -H -n`
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD" = "maximum" ] || [ "$MAX_FD" = "max" ] ; then
            MAX_FD="$MAX_FD_LIMIT"
        fi
        ulimit -n $MAX_FD
        if [ $? -ne 0 ] ; then
            warn "Could not set maximum file descriptor limit: $MAX_FD"
        fi
    else
        warn "Could not query maximum file descriptor limit: $MAX_FD_LIMIT"
    fi
fi

# For Darwin, add options to specify how the application appears in the dock
if [ "$(uname)" = "Darwin" ] ; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin, switch paths to Windows format before running java
if [ "$CYGWIN" = "true" ] || [ "$MSYS" = "true" ] ; then
    APP_HOME=`cygpath --path --mixed "$APP_HOME"`
    CLASSPATH=`cygpath --path --mixed "$CLASSPATH"`
    JAVACMD=`cygpath --unix "$JAVACMD"`

    # We build the pattern for arguments to be converted via cygpath
    ROOTDIRSRAW=`find / -maxdepth 1 -mindepth 1 -type d 2>/dev/null`
    SEP=""
    for dir in $ROOTDIRSRAW ; do
        ROOTDIRS="$ROOTDIRS$SEP$dir"
        SEP="|"
    done
    OURCYGPATTERN="(^($ROOTDIRS))"
    # Add a user-defined pattern to the cygpath arguments
    if [ "$GRADLE_CYGPATTERN" != "" ] ; then
        OURCYGPATTERN="$OURCYGPATTERN|($GRADLE_CYGPATTERN)"
    fi
    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    i=0
    for arg in "$@" ; do
        CHECK=`echo "$arg"|egrep -c "$OURCYGPATTERN" -`
        CHECK2=`echo "$arg"|egrep -c "^-" -`
        if [ $CHECK -ne 0 ] && [ $CHECK2 -eq 0 ] ; then
            eval `echo "arguments$i"`=`cygpath --path --ignore --mixed "$arg"`
        else
            eval `echo "arguments$i"`="\"$arg\""
        fi
        i=$((i+1))
    done
    case $i in
        (0) set -- ;;
        (1) set -- "$arguments0" ;;
        (2) set -- "$arguments0" "$arguments1" ;;
        (3) set -- "$arguments0" "$arguments1" "$arguments2" ;;
        (4) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" ;;
        (5) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" "$arguments4" ;;
        (6) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" "$arguments4" "$arguments5" ;;
        (7) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" "$arguments4" "$arguments5" "$arguments6" ;;
        (8) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" "$arguments4" "$arguments5" "$arguments6" "$arguments7" ;;
        (9) set -- "$arguments0" "$arguments1" "$arguments2" "$arguments3" "$arguments4" "$arguments5" "$arguments6" "$arguments7" "$arguments8" ;;
    esac
fi

# Escape application args
save () {
    for i do printf %s\\n "$i" | sed "s/'/'\\\\''/g;1s/^/'/;\$s/\$/' \\\\/"; done
    echo " "
}
APP_ARGS=$(save "$@")

# Collect all arguments for the java command, following the shell quoting and substitution rules
eval set -- "$DEFAULT_JVM_OPTS" "$JAVA_OPTS" "$GRADLE_OPTS" "-classpath" "\"$APP_HOME/gradle/wrapper/gradle-wrapper.jar\"" "org.gradle.wrapper.GradleWrapperMain" "$APP_ARGS"

exec "$JAVACMD" "$@"
