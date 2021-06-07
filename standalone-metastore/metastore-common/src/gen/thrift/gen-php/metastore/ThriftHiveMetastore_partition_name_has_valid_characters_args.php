<?php
namespace metastore;

/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class ThriftHiveMetastore_partition_name_has_valid_characters_args
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'part_vals',
            'isRequired' => false,
            'type' => TType::LST,
            'etype' => TType::STRING,
            'elem' => array(
                'type' => TType::STRING,
                ),
        ),
        2 => array(
            'var' => 'throw_exception',
            'isRequired' => false,
            'type' => TType::BOOL,
        ),
    );

    /**
     * @var string[]
     */
    public $part_vals = null;
    /**
     * @var bool
     */
    public $throw_exception = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['part_vals'])) {
                $this->part_vals = $vals['part_vals'];
            }
            if (isset($vals['throw_exception'])) {
                $this->throw_exception = $vals['throw_exception'];
            }
        }
    }

    public function getName()
    {
        return 'ThriftHiveMetastore_partition_name_has_valid_characters_args';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::LST) {
                        $this->part_vals = array();
                        $_size1634 = 0;
                        $_etype1637 = 0;
                        $xfer += $input->readListBegin($_etype1637, $_size1634);
                        for ($_i1638 = 0; $_i1638 < $_size1634; ++$_i1638) {
                            $elem1639 = null;
                            $xfer += $input->readString($elem1639);
                            $this->part_vals []= $elem1639;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::BOOL) {
                        $xfer += $input->readBool($this->throw_exception);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('ThriftHiveMetastore_partition_name_has_valid_characters_args');
        if ($this->part_vals !== null) {
            if (!is_array($this->part_vals)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('part_vals', TType::LST, 1);
            $output->writeListBegin(TType::STRING, count($this->part_vals));
            foreach ($this->part_vals as $iter1640) {
                $xfer += $output->writeString($iter1640);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->throw_exception !== null) {
            $xfer += $output->writeFieldBegin('throw_exception', TType::BOOL, 2);
            $xfer += $output->writeBool($this->throw_exception);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
