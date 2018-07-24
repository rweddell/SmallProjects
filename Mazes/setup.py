
from setuptools import setup, find_packages

with open('README.md') as f:
    readme = f.read()

setup(
    name="Mazes",
    version='0.0.0',
    description='Translated Mazes for Programmers Ruby->Pthon',
    author='Rob Weddell',
    packages=find_packages()
)