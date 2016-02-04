#!/usr/bin/python
#  this is the test harness for the simulation time service
#
#  It excercise the zmq/protobuf services provided by it.
#
# time time gets displayed in the friendly format
# Jan 1 1970 14:23:21.234

import zmq
import re
from pprint import pprint
import traceback
import time
import datetime
import sys
sys.path.append("msg")
from hello_pb2 import *

from inspect import trace

def test():
    pass
       
def main(): 
    test()

if __name__ == "__main__":
    # execute only if run as a script
    main()
