
 #!/bin/bash
echo "Cleaning Filesystem Cache..."
echo 3 > /proc/sys/vm/drop_caches 2>&1 /dev/null
echo "Done\n"